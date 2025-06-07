package com.example.batch2bookmanagementsystem.repository;

import com.example.batch2bookmanagementsystem.models.Book;
import com.example.batch2bookmanagementsystem.models.Genre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    Connection connection=null;

    String url;
    String username;
    String password;

    public BookRepository(@Value("${db.url}") String url, @Value("${db.username}") String username, @Value("${db.password}") String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        createTable();
    }

    private void createTable() throws SQLException {
        String query = "Create table if not exists book(id int primary key auto_increment,title varchar(50) not null,author varchar(50)," +
                "authorEmail varchar(50),genre varchar(50) not null,createdOn date,updatedOn date)";

        Statement statement = getConnection().createStatement();
        statement.execute(query);
    }

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(this.url,this.username,this.password);
        }
        return connection;
    }




    public void addBook(Book book) throws SQLException {
        String query = "insert into book(title,author,authorEmail,genre,createdOn,updatedOn) values(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setString(3,book.getAuthorEmail());
        preparedStatement.setString(4,book.getGenre().name());
        preparedStatement.setDate(5,new Date(book.getCreatedOn().getTime()));
        preparedStatement.setDate(6,new Date(book.getUpdatedOn().getTime()));

        preparedStatement.execute();

    }

    public List<Book> getAll() throws SQLException {
        String query = "select * from book";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setAuthorEmail(resultSet.getString("authorEmail"));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));
            books.add(book);
        }
        return books;

    }

    public Book getById(int id) throws SQLException {
        String query = "select * from book where id=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setAuthorEmail(resultSet.getString("authorEmail"));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));
        }
        return book;
    }
}
