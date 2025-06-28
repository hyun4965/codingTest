package lab.apiu;

import java.io.IOException;
import java.util.Hashtable;

public class AppMain implements IAlphaServer{
  //IAlphaServer에 있는 init
  public void init(String paramString, Hashtable paramHashtable) { }
  //IAlphaServer에 있는 homePage
  public void homePage(Environment paramEnvironment) {
    try {
      // 1. 출력 스트림 가져옴
      HTMLHelper localHTMLHelper = new HTMLHelper(paramEnvironment.getOutputStream());

      // 2. HTML 문서 시작
      localHTMLHelper.startHTMLDoc();

      // 3. 문단 추가
      try {
        localHTMLHelper.appendSimpleHTMLPara("Hello World 60222096");
      } catch (APIException e) {
        // APIException 발생 시 무시
      }

      // 4. HTML 문서 종료
      localHTMLHelper.endHTMLDoc();
    } catch (IOException localIOException) {
      // OutputStream이 null이면 IOException 발생
    }
  }

}
