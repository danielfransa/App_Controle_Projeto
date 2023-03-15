package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    public void save(Task task){
        
        String sql = "INSERT INTO tasks (nome, descricao, status, observacao, prazo, dataCriacao, dataModificacao, idProj) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn  = null;
        PreparedStatement statement = null;
                
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, task.getNome());
            statement.setString(2, task.getDescricao());
            statement.setBoolean(3, task.isStatus());
            statement.setString(4, task.getObservacao());
            statement.setDate(5, new Date(task.getPrazo().getTime()));
            statement.setDate(6, new Date(task.getDataCriacao().getTime()));
            statement.setDate(7, new Date(task.getDataModificacao().getTime()));
            statement.setInt(8, task.getIdProj());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa " + e.getMessage(), e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
           
        }
    }
    
    public void update(Task task){
        
        String sql = "UPDATE tasks SET nome = ?, descricao = ?, status = ?, observacao = ?, prazo = ?, dataCriacao = ?, dataModificacao = ?, idProj = ? WHERE id = ?";
        
        Connection conn  = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, task.getNome());
            statement.setString(2, task.getDescricao());
            statement.setBoolean(3, task.isStatus());
            statement.setString(4, task.getObservacao());
            statement.setDate(5, new Date (task.getPrazo().getTime()));
            statement.setDate(6, new Date(task.getDataCriacao().getTime()));
            statement.setDate(7, new Date(task.getDataModificacao().getTime()));
            statement.setInt(8, task.getIdProj());
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa " + e.getMessage(), e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM tasks WHERE idProj = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Task> tasks = new ArrayList<Task>();
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idProject);
            result = statement.executeQuery();
            
            while(result.next()){
                Task task = new Task();
                task.setId(result.getInt("id"));
                task.setNome(result.getString("nome"));
                task.setDescricao(result.getString("descricao"));
                task.setStatus(result.getBoolean("status"));
                task.setObservacao(result.getString("observacao"));
                task.setPrazo(result.getDate("prazo"));
                task.setDataCriacao(result.getDate("dataCriacao"));
                task.setDataModificacao(result.getDate("dataModificacao"));
                task.setIdProj(result.getInt("idProj"));
                
                tasks.add(task);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a tarefa " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, result);
        }
        
        return tasks;
    }
}
