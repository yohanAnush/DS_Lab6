package bookservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {
	
	List<Book> books;
	
	
	public BookService() {
		books = Books.getBooks();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		return books;
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id) {
		  for(Book b : books) {
			  if ( b.getId() == id)
				   return b;
		  }
		  // book with the given id is not found, so throw 404 error
		  throw new NotFoundException(); 
	}
	
	// POST req path: http://localhost:8080/book_service/rest/books/add/bookname/price
	//       example: http://localhost:8080/book_service/rest/books/add/Village by the sea/2500
	@Path("add/{name}/{price}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add(@PathParam("name") String name, @PathParam("price") double price) {
		Books.add(name, price);
	}
	
	@Path("remove/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void remove(@PathParam("id") int id) {
		Books.remove(id);
	}
	
}