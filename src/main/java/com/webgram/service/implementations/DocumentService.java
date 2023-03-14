package com.webgram.service.implementations;

import com.webgram.entity.Document;
import com.webgram.repository.DocumentRepository;
import com.webgram.service.interfaces.IDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService implements IDocument
{
    private final DocumentRepository documentRepository;

    @Override
    public Document addDocument(Document document)
    {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Long id, Document document)
    {
        Document isExisted = getOneDocument(id);

        isExisted.setReference(document.getReference());
        isExisted.setTitre(document.getTitre());
        isExisted.setChemin(document.getChemin());
        isExisted.setTaille(document.getTaille());
        isExisted.setDateAjout(document.getDateAjout());

        return documentRepository.save(isExisted);
    }

    @Override
    public void deleteDocument(Long id)
    {
        Document isExisted = getOneDocument(id);

        documentRepository.delete(isExisted);
    }

    @Override
    public List<Document> getAllDocument()
    {
        return documentRepository.findAll();
    }

    @Override
    public Document getOneDocument(Long id)
    {
        return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document doesn't exist !"));
    }
}
