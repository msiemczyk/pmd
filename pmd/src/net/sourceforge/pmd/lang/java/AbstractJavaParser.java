/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.lang.java;

import java.io.Reader;
import java.util.Map;

import test.net.sourceforge.pmd.testframework.AbstractTokenizerTest;

import net.sourceforge.pmd.lang.AbstractParser;
import net.sourceforge.pmd.lang.TokenManager;
import net.sourceforge.pmd.lang.ast.AbstractTokenManager;
import net.sourceforge.pmd.lang.ast.JavaCharStream;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.JavaParser;
import net.sourceforge.pmd.lang.java.ast.ParseException;

/**
 * This is a generic Java specific implementation of the Parser interface. It
 * creates a JavaParser instance, and sets the exclude marker. It also exposes
 * the exclude map from the JavaParser instance.
 * 
 * @see AbstractParser
 * @see JavaParser
 */
public abstract class AbstractJavaParser extends AbstractParser {
    private JavaParser parser;

    public TokenManager createTokenManager(Reader source) {
	return new JavaTokenManager(source);
    }

    /**
     * Subclass should override this method to modify the JavaParser as needed.
     */
    protected JavaParser createJavaParser(Reader source) throws ParseException {
	parser = new JavaParser(new JavaCharStream(source));
	String excludeMarker = getExcludeMarker();
	if (excludeMarker != null) {
	    parser.setExcludeMarker(excludeMarker);
	}
	return parser;
    }

    public Node parse(String fileName, Reader source) throws ParseException {
	AbstractTokenManager.setFileName(fileName);
	return createJavaParser(source).CompilationUnit();
    }

    public Map<Integer, String> getExcludeMap() {
	return parser.getExcludeMap();
    }
}