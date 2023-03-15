
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


public class ProjectController {
    
    public void save (Project project){
        
        String sql = "INSERT INTO projects (nome, descricao, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?)";
        
        Connection conn  = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2, project.getDescricao());
            statement.setDate(3,new Date(project.getDataCriacao().getTime()));
            statement.setDate(4,new Date(project.getDataModificacao().getTime()));
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto " + e.getMessage(), e);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
           
        } 
    }
    
    public void update(Project project){
            
        String sql = "UPDATE projects SET nome = ?, descricao = ?, dataCriacao = ?, dataModificacao = ? WHERE id = ?";

        Connection conn  = null;
        PreparedStatement statement = null;

        try {

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2, project.getDescricao());
            statement.setDate(3,new Date(project.getDataCriacao().getTime()));
            statement.setDate(4,new Date(project.getDataModificacao().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o projeto " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int projectId){
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
            
        } catch (Exception e) {
            
            throw new RuntimeException("Erro ao deletar o projeto " + e.getMessage(), e);
            
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }      
    }
    
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Project> projects = new ArrayList<>();
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                Project project = new Project();
                project.setId(result.getInt("id"));
                project.setNome(result.getString("nome"));
                project.setDescricao(result.getString("descricao"));
                project.setDataCriacao(result.getDate("dataCriacao"));
                project.setDataModificacao(result.getDate("dataModificacao"));
                
                projects.add(project);
                
            }
        } catch (Exception e) {
            
            throw new RuntimeException("Erro ao buscar a tarefa " + e.getMessage(), e);
            
        } finally {
            
            ConnectionFactory.closeConnection(conn, statement, result);
            
        }
        
        return projects;
    }
    
}
