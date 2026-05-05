package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobilePhoneTest {

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        MobilePhone myPhone = Mockito.mock(MobilePhone.class);

        assertFalse(myPhone.needsCharging());
        assertEquals(0.0, myPhone.getFreeStorage());
    }

    @Test
    public void testExpectation() {
        MobilePhone myPhone = Mockito.mock(MobilePhone.class);

        assertFalse(myPhone.needsCharging());
        Mockito.when(myPhone.needsCharging()).thenReturn(true);
        assertTrue(myPhone.needsCharging());
    }

    @Test
    public void shouldCallLaunchApplication() {
        MobilePhone myPhone = Mockito.mock(MobilePhone.class);

        myPhone.launchApplication("Tetris4D");
        Mockito.verify(myPhone).launchApplication("Tetris4D");
    }

    @Test
    public void shouldCallGetFreeStorage() {
        MobilePhone myPhone = Mockito.mock(MobilePhone.class);

        myPhone.getFreeStorage();
        Mockito.verify(myPhone).getFreeStorage();
    }
}
