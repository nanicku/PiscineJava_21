package edu.school21.render;

import edu.school21.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void outputSource(String source) {
        System.err.println(preProcessor.preProcess(source));
    }
}
