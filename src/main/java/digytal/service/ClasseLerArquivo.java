package digytal.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ClasseLerArquivo {
	public void ler(String caminhoArquivo) throws FileNotFoundException {
		
		FileReader fr = new FileReader(new File(caminhoArquivo));
		
	}
}
