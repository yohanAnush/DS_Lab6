package bookservice;

import java.util.ArrayList;
import java.util.List;

public class Books {
	
	private static ArrayList<Book> books = new ArrayList<>();
	
	static {
		books.add(new Book(1, "The Outliers", 500));
		books.add(new Book(2, "World Is Flat", 550));
	}
	
	public static List<Book> getBooks() {
		return books;
	}
	
	// adding a book.
	// we determine the id by checking the id of the last item in the books.
	// if the books array list is empty, we'll start with id = 1.
	public static void add(String name, double price) {
		int id = 1;
		
		// generate a new id if the books array list is populated.
		if (!books.isEmpty()) {
			id = books.get(books.size()-1).getId() + 1;
		}
		
		Book newBook = new Book(id, name, price);
		books.add(newBook);
	}
	
	// removing a book.
	// we delete the book that has the id provided by the user.
	public static void remove(int id) {
		if (!books.isEmpty()) {
			// we go through all the books till we find a book that has the above id.
			for (Book book: books) {
				if (book.getId() == id) {
					books.remove(book);
					break;
				}
			}
		}
	}
}