package edu.school21.render;

import edu.school21.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void outputSource(String source) {
        System.out.println(preProcessor.preProcess(source));
    }
}
