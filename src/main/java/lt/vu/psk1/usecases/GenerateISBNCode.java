package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import lt.vu.psk1.services.ISBNCodeGenerator;

@SessionScoped
@Named
public class GenerateISBNCode implements Serializable {
    @Inject
    ISBNCodeGenerator isbnCodeGenerator;

    private Future<String> isbnCodeGenerationTask = null;

    public String generateISBNCode() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        isbnCodeGenerationTask = isbnCodeGenerator.generateISBNCode();
        return  "/books.xhtml?faces-redirect=true&authorId=" + requestParameters.get("authorId");
    }

    public boolean isISBNCodeGenerated() {
        return isbnCodeGenerationTask != null;
    }

    public boolean isISBNCodeGenerationRunning() {
        return isbnCodeGenerationTask != null && !isbnCodeGenerationTask.isDone();
    }

    public String getISBNCodeGenerationStatus() throws ExecutionException, InterruptedException {
        if (isbnCodeGenerationTask == null) {
            return null;
        } else if (isISBNCodeGenerationRunning()) {
            return "ISBN code generation in progress";
        }
        return isbnCodeGenerationTask.get();
    }
}
