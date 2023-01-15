import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {
  
  public static void main(String[] args){
      CharStream cs = null;
      try {
          cs = fromFileName("gen/test.txt");
          JSONLexer lexer = new JSONLexer(cs);
          CommonTokenStream token = new CommonTokenStream(lexer);
          JSONParser parser = new JSONParser(token);
          ParseTree tree = parser.json();

          JSONMyVisitor visitor = new JSONMyVisitor();

          visitor.visit(tree);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }
  
}
