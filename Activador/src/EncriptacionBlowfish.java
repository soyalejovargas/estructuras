
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EncriptacionBlowfish
{

    private static final String LLAVE = "09090951";

    // Método para encriptar
    public String encriptar(String texto) throws Exception
	{
        SecretKeySpec secretKey = new SecretKeySpec(LLAVE.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textoEncriptado = cipher.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().withoutPadding().encodeToString(textoEncriptado);
    }

    // Método para desencriptar
    public String desencriptar(String textoEncriptado) throws Exception
	{
        SecretKeySpec secretKey = new SecretKeySpec(LLAVE.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(textoDesencriptado, "UTF-8");
    }

    // Método para desencriptar y volver a encriptar concatenando con la fecha
    public String encriptarConFecha(String textoEncriptado) throws Exception
	{
        String textoDesencriptado = desencriptar(textoEncriptado);
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String textoConFecha = textoDesencriptado + "-" + fechaActual;
        return encriptar(textoConFecha);
    }
}
