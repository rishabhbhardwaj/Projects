/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * @author Rishabh
 */
import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.Locale;
public class Speech {
   
	void speak(String in1) {
		try {
			Synthesizer synth =Central.createSynthesizer(new SynthesizerModeDesc(null));
                         synth.allocate();
                            
                       
                        synth.resume();
			synth.speakPlainText(in1, null);
			synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synth.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
		}
                
	}
}
