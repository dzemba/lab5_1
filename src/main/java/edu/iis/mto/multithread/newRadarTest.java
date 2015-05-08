package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.powtarzalnosc.Repeat;


public class newRadarTest {

	@Rule
	public powtarzalnosc repeatRule = new powtarzalnosc();
	
	@Test
	@Repeat(times = 1000)
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		newRadar radar = new newRadar(batteryMock);
		radar.setExecutor(new Executor() {
			@Override
			public void execute(Runnable command) {
				command.run();
			}
		});

		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}