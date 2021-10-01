package Junit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import M3.clients.Afficheur;
import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.proxy.Canal;
import M3.scheduler.Scheduler;
import M3.strategy.AlgoDiffusion;
import M3.strategy.DiffusionAtomique;


class TestClass {

	private Scheduler scheduler;

	
	@BeforeEach
	public void initVaraibles() {
		this.scheduler = new Scheduler();

	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
