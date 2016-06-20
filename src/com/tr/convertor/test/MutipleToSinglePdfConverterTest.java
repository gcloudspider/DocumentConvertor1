
package com.tr.convertor.test;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.DocumentException;
import com.tr.fileconvertor.MutipleToOnePdfContvertor;

/**
 * @author vishwajeet kumar
 * @date 06/20/2016
 */
public class MutipleToSinglePdfConverterTest {
	
	//Mutiple pdf to One pdf Convertor test 
		 public static void main(String[] args) {
		        List<InputStream> list = new ArrayList<InputStream>();
		        try {
		            // Source pdfs
		            list.add(new FileInputStream(new File("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/1.pdf")));
		            list.add(new FileInputStream(new File("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/2.pdf")));

		            // Resulting pdf
		            OutputStream out = new FileOutputStream(new File("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/result.pdf"));

		            MutipleToOnePdfContvertor.doMerge(list, out);

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (DocumentException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

}
