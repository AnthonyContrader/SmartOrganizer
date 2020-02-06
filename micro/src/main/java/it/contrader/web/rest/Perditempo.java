package it.contrader.web.rest;

import it.contrader.service.dto.ToolDTO;

public class Perditempo implements Runnable {

private	ToolDTO tooldto;
private	int tempo;
int usura;

public Perditempo(ToolDTO tooldto,int tempo) {
	this.tempo=tempo;
	this.tooldto=tooldto;
}

public ToolDTO Usura() {
	run();
	
	return tooldto;
}

	@Override
	public void run() {
		try {
			if(tooldto.getLifetime()>15) {
				
			Thread.sleep(tempo);
			int life = tooldto.getLifetime();
			tooldto.setLifetime(--life);
		
			
			}
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
