package device.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit
public class SpeakerTest {

    @Test
    void setVolumeWhenSpeakerIsOffIsRejected() {
        // given
        int prevVolume = 13;
        Speaker speaker = new Speaker(prevVolume, prevVolume);
        speaker.switchOff();

        // when
        speaker.setVolume(0);

        // then
        assertEquals(prevVolume, speaker.getVolume());
    }

    @Test
    void setVolumeCapsAtMaxVolume() {
        // given
        int prevMaxVolume = 13;
        Speaker speaker = new Speaker(prevMaxVolume, prevMaxVolume);

        // when
        speaker.setVolume(prevMaxVolume + 1);

        // then
        assertEquals(prevMaxVolume, speaker.getVolume());
    }

    @Test
    void settingNegativeVolumeIsRejected() {
        // given
        int prevVolume = 13;
        Speaker speaker = new Speaker(prevVolume, prevVolume);

        // when
        speaker.setVolume(-1);

        // then
        assertEquals(prevVolume, speaker.getVolume());
    }

    @Test
    void settingCorrectVolume() {
        // given
        int prevVolume = 13;
        int newVolume = 1;
        Speaker speaker = new Speaker(prevVolume, prevVolume);

        // when
        speaker.setVolume(newVolume);

        // then
        assertEquals(newVolume, speaker.getVolume());
    }
}
