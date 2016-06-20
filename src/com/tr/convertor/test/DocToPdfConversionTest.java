/**
 * 
 */
package com.tr.convertor.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.tr.fileconvertor.Converter;
import com.tr.fileconvertor.DocToPDFConverter;


/**
 * @author vishwajeet kumar
 * @date 06/20/2016
 */
public class DocToPdfConversionTest {

	/**
	 * 
	 */
	public DocToPdfConversionTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inPath = "C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/Job Broadcasting API-1.doc";
		String outPath = "C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/Job Broadcasting API-1.pdf";
		File inFile = new File(inPath);
		FileInputStream iStream = null;
		try {
			iStream = new FileInputStream(inFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream inStream = iStream;
		
		File outFile = new File(outPath);
		try{
			//Make all directories up to specified
			outFile.getParentFile().mkdirs();
		} catch (NullPointerException e){
			//Ignore error since it means not parent directories
		}
		
		try {
			outFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileOutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OutputStream outStream = oStream;
		boolean shouldShowMessages = true;
		Converter converter = new DocToPDFConverter(inStream, outStream, shouldShowMessages, true);
		
		
		if(converter == null){
			System.out.println("Unable to determine type of input file.");
		} else {
			try {
				converter.convert();//doc to pdf				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	

}
