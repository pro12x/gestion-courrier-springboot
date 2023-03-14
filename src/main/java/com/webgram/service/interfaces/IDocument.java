package com.webgram.service.interfaces;

import com.webgram.entity.Document;

import java.util.List;

public interface IDocument
{
    Document addDocument(Document document);
    Document updateDocument(Long id, Document document);
    void deleteDocument(Long id);
    List<Document> getAllDocument();
    Document getOneDocument(Long id);
}
