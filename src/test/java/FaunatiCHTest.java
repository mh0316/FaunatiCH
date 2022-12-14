import org.junit.jupiter.api.Test;
import utils.VerificadorContrasena;
import utils.VerificadorNombre;
import utils.VerificadorRut;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FaunatiCHTest {

    @Test
    public void probarVerificadorDeNombre() {
        assertTrue(VerificadorNombre.validarNombre("Nico"));  // retorna true
        assertFalse(VerificadorNombre.validarNombre(" "));  // retorna false
        assertFalse(VerificadorNombre.validarNombre("Marce lo"));
        assertTrue(VerificadorNombre.validarNombre("CR7_siuuu"));
    }

    @Test
    public void probarVerificadorDeRut() {
        assertTrue(VerificadorRut.validarRut("208860909"));  // retorna true
        assertFalse(VerificadorRut.validarRut("2102415077"));  // retorna true
        assertFalse(VerificadorRut.validarRut("20.886.090-9"));  // retorna true
        assertFalse(VerificadorRut.validarRut("...."));  // retorna true
        assertFalse(VerificadorRut.validarRut("----"));  // retorna true
        assertFalse(VerificadorRut.validarRut("20.886.090-9"));  // va a fallar
    }

    @Test
    public void probarVerificadorDeContraseña() {
        assertFalse(VerificadorContrasena.verificarContraseña("nico12345678"));
        assertFalse(VerificadorContrasena.verificarContraseña("玩动物群"));
        assertTrue(VerificadorContrasena.verificarContraseña("marce22"));
        assertFalse(VerificadorContrasena.verificarContraseña("progra icc"));
        assertTrue(VerificadorContrasena.verificarContraseña("Mañana14"));
    }
}