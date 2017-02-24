import java.io.Reader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String args[]) throws Exception {
		Reader inp = new InputStreamReader(System.in);
		new parser(new Yylex(inp)).parse();
	}
}
