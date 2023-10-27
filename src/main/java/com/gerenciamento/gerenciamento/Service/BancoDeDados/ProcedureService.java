package com.gerenciamento.gerenciamento.Service.BancoDeDados;

import com.gerenciamento.gerenciamento.Service.AlunoService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.DisciplinaMediaDTO;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public class ProcedureService {

    private static final String BANCO_URL = "jdbc:mysql://localhost:3306/gerenciamentoescolar";
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "root";

    private static String comandoSql;

//    private final AlunoRepository alunoRepository;
//    private final AlunoService alunoService;


    public String createGerarMediaDisciplina() {
        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {
            comandoSql =
            """
            CREATE PROCEDURE gerarMediaDisciplina(in id int)
            BEGIN
            select pr.aluno_id, u.nome, a.turma_id as "turma_id", avg(pr.nota) as "media"
            from prova pr join aluno a join usuario u
            on pr.aluno_id = a.id
            and pr.aluno_id = u.id
            and u.id = a.id
            where pr.disciplina_id = id
            group by pr.aluno_id;
            END
            """;
                 //drop procedure gerarMediaDisciplina;
            statement.execute(comandoSql);
            return "\nProcedure \"gerarMediaDisciplina(in id int)\" criada com sucesso.";

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return "\nFalha ao tentar criar a procedure \"gerarMediaDisciplina(in id int)\" : " + throwables.getMessage();
        }
    }

    //CHECKPOINT

    public Collection<DisciplinaMediaDTO> callGerarMediaDisciplina(int id) {
        //mudar para retornar a media de todas as disciplinas a acima a mesma coisa (talvez mudar estrutura do BD pois aluno pode ter varia disciplinas[a verificar])

        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             CallableStatement statement = conn.prepareCall("{call gerarMediaDisciplina("+id+")}");) {

            //mudar para prepared statement e receber por parametro
            boolean hasResults = statement.execute();

            if (hasResults) {
                ResultSet resultSet = statement.getResultSet();

                Collection<DisciplinaMediaDTO> mediasDisciplina = new ArrayList<>();
                while(resultSet.next()){
                    System.out.println("entrei no while");
                    System.out.println(resultSet.getDouble("media"));
                    System.out.println(resultSet.getInt("aluno_id"));
                    DisciplinaMediaDTO mediaDisciplina = new DisciplinaMediaDTO();
                    mediaDisciplina.setMedia(resultSet.getDouble("media"));

                    mediaDisciplina.setAluno_nome((resultSet.getString("nome")));
                    mediaDisciplina.setAluno_id(resultSet.getInt("aluno_id"));
                    mediaDisciplina.setTurma_id(resultSet.getInt("turma_id"));
                    BeanUtils.copyProperties(resultSet, mediaDisciplina);
                    mediasDisciplina.add(mediaDisciplina);
                }
                System.out.println(mediasDisciplina);
                resultSet.close();
                return mediasDisciplina;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public String criarGerarBoletimDisciplina (){

        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {
            comandoSql = "DROP PROCEDURE IF EXISTS gerarBoletim;";
            statement.execute(comandoSql);


            comandoSql = """
            CREATE PROCEDURE gerarBoletim(IN turma_id INT, IN disciplina_id int , in aluno_id int)
            BEGIN
    
            Insert into boletim (turma_id,disciplina_id,aluno_id) values (turma_id,disciplina_id, aluno_id);
    
            END
            """;
            statement.execute(comandoSql);
            return "\nProcedure \"gerarBoletim(IN turma_id INT, IN disciplina_id int , in aluno_id int)\" criada com sucesso.";

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return "\nFalha ao tentar criar a procedure \"gerarBoletim(IN turma_id INT, IN disciplina_id int , in aluno_id int)\" : " + throwables.getMessage();
        }
    }

    public void gerarBoletimDisciplina(int turma_id,  int disciplina_id, int aluno_id){

        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             CallableStatement statement = conn.prepareCall("{call gerarBoletim(" + turma_id + ", " + disciplina_id + "," + aluno_id + ")}");) {
            //mudar para prepared statement
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String criarTriggerGerarMediaBoletim (){

        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {

            comandoSql = "DROP TRIGGER IF EXISTS gerarMediaBoletim;";
            statement.execute(comandoSql);


            comandoSql = """
            CREATE TRIGGER gerarMediaBoletim
            
            BEFORE INSERT ON boletim FOR EACH ROW
            BEGIN
            SET NEW.media =
                    (SELECT AVG(pr.nota) FROM prova pr JOIN professor pf
            ON pr.professor_id = pf.id
            WHERE NEW.aluno_id = pr.aluno_id
            AND NEW.turma_id = pr.turma_id);
        
            END
            """;
            statement.execute(comandoSql);
            return "\nTrigger \"gerarMediaBoletim\" criada com sucesso.";

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return "\nFalha ao tentar criar o trigger \"gerarMediaBoletim\" : " + throwables.getMessage();
        }
    }




//    drop trigger if exists gerarMediaBoletim;
//    delimiter $$
//    create trigger gerarMediaBoletim
//    before insert on boletim for each row
//    begin
//    set new.media =
//            (select avg(pr.nota) from prova pr join professor pf
//    on pr.professor_id = pf.id
//    where new.aluno_id = pr.aluno_id
//    and new.turma_id = pr.turma_id);
//
//    end $$
//    delimiter ;

//    DROP TRIGGER IF EXISTS gerarMediaBoletim;
//    delimiter $$
//    CREATE TRIGGER gerarMediaBoletim
//    BEFORE INSERT ON boletim FOR EACH ROW
//            BEGIN
//    SET NEW.media =
//            (SELECT AVG(pr.nota) FROM prova pr JOIN professor pf
//    ON pr.professor_id = pf.id
//    WHERE NEW.aluno_id = pr.aluno_id
//    AND NEW.turma_id = pr.turma_id);
//
//    END $$
//    delimiter ;

}
