package M3.strategy;

import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class SequenceDiffusion implements AlgoDiffusion {

	private Capteur capteur;
	
	public SequenceDiffusion(CapteurImpl capteur) {
		this.capteur = capteur;
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {

		}
	}
