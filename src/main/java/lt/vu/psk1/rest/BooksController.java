package lt.vu.psk1.rest;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.dtos.BookDTO;
import lt.vu.psk1.entities.Author;
import lt.vu.psk1.entities.Book;
import lt.vu.psk1.persistance.AuthorDAO;
import lt.vu.psk1.persistance.BookDAO;

@ApplicationScoped
@Path("/books")
public class BooksController {

    @Inject
    @Getter
    @Setter
    private BookDAO bookDAO;

    @Inject
    @Getter
    @Setter
    private AuthorDAO authorDAO;

    @Getter
    @Setter
    private Book book;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(BookDTO bookDTO) {
        try {
            if (bookDTO == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Book bookToCreate = new Book();
            Author author = authorDAO.findByName(bookDTO.getAuthorFirstName(), bookDTO.getAuthorLastName());
            bookToCreate.setAuthor(author);
            bookToCreate.setTitle(bookDTO.getTitle());
            bookToCreate.setISBNCode(bookDTO.getISBNCode());
            bookDAO.persist(bookToCreate);

            URI location = UriBuilder.fromResource(BooksController.class)
                    .path("/{id}")
                    .resolveTemplate("id", bookToCreate.getId())
                    .build();

            return Response.created(location).build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Book book = bookDAO.findOne(id);

        BookDTO bookDTO = BookDTO.of(book);

        if (bookDTO == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(bookDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long bookId, BookDTO bookDTO) {
        try {
            Book existingBook = bookDAO.findOne(bookId);

            if (existingBook == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingBook.setTitle(bookDTO.getTitle());
            bookDAO.update(existingBook);
            return Response.ok().build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
