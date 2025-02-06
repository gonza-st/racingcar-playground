package org.gonza.javaplayground.io.handler;

public interface InputHandler {
    String getStringInputWithGuideMsg(String guideMessage);

    Integer getIntegerInputWithGuideMsg(String guideMessage);
}
