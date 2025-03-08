package com.Residence.Residence.service;

import com.Residence.Residence.Entities.Paiement;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public byte[] generatePdf(Paiement paiement) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();
        document.add(new Paragraph("Reçu de Paiement"));
        document.add(new Paragraph("ID: " + paiement.getId()));
        document.add(new Paragraph("Montant Payé: " + paiement.getMontantPaye()));
        document.add(new Paragraph("Statut: " + paiement.getStatut()));
        document.add(new Paragraph("Date de Paiement: " + paiement.getDatePaiement()));
        document.add(new Paragraph("Résident: " + paiement.getResident().getNom() + " " + paiement.getResident().getPrenom()));
        document.close();

        return outputStream.toByteArray();
    }
}