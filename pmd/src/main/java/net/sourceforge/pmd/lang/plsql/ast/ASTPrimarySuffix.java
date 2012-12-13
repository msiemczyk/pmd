/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

/* Generated By:JJTree: Do not edit this line. ASTPrimarySuffix.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
package net.sourceforge.pmd.lang.plsql.ast;

public class ASTPrimarySuffix extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode{
  public ASTPrimarySuffix(int id) {
    super(id);
  }

  public ASTPrimarySuffix(PLSQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(PLSQLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  private boolean isArguments;
  private boolean isArrayDereference;

  public void setIsArrayDereference() {
      isArrayDereference = true;
  }

  public boolean isArrayDereference() {
      return isArrayDereference;
  }

  public void setIsArguments() {
      this.isArguments = true;
  }

  public boolean isArguments() {
      return this.isArguments;
  }

  /**
   * Get the number of arguments for this primary suffix.  One should call
   * {@link #isArguments()} to see if there are arguments.  If this method is
   * called when there are no arguments it returns <code>-1</code>.
   * @return A non-negative argument number when there are arguments,
   * <code>-1</code> otherwise.
   */
  public int getArgumentCount() {
      if (!this.isArguments()) {
	  return -1;
      }
      return ((ASTArguments)jjtGetChild(jjtGetNumChildren()-1)).getArgumentCount();
  }
}
/* JavaCC - OriginalChecksum=5b2263901be5de081a66c8930ce58545 (do not edit this line) */
