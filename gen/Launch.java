import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

import java.io.FileWriter;

public class Launch {


  public static void main(String[] args){
      CharStream cs = null;

      String filename = "ext_parsed.txt";

      try {
          FileWriter fileWriter = new FileWriter(filename);

          cs = fromFileName("gen/ext_test.txt");
          JSONLexer lexer = new JSONLexer(cs);
          CommonTokenStream token = new CommonTokenStream(lexer);
          JSONParser parser = new JSONParser(token);
          ParseTree tree = parser.json();

          JSONMyVisitor visitor = new JSONMyVisitor();

          visitor.visit(tree);

          fileWriter.append(visitor.buffer);

          fileWriter.close();

      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }
}

