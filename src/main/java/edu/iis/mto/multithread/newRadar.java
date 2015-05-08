package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class newRadar {
	private PatriotBattery battery;
	private Executor exec;

	public newRadar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	public void setExecutor(Executor e) {
		this.exec = e;
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					battery.launchPatriot();
				}
			}
		};

		exec.execute(launchPatriotTask);
	}

}