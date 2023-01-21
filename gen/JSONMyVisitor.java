public class JSONMyVisitor extends JSONBaseVisitor<Object>{
    StringBuffer buffer;

    public JSONMyVisitor() {
        this.buffer= new StringBuffer();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitJson(JSONParser.JsonContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitObj(JSONParser.ObjContext ctx) {
        for (JSONParser.PairContext pairContext : ctx.pair()) {
            String temp = "";
            if (pairContext.value().STRING() != null){
                temp = "string "+pairContext.STRING().getText().split("\"")[1] +" = "+pairContext.value().STRING() +";\n";
            } else if (pairContext.value().NUMBER() != null){
                temp = "int "+pairContext.STRING().getText().split("\"")[1] +" = "+pairContext.value().NUMBER() +";"+"\n";
            } else if (pairContext.value().arr() != null){
                temp = "int "+pairContext.STRING().getText().split("\"")[1] + " = [";
                for (JSONParser.ValueContext valueContext : pairContext.value().arr().value()) {
                    if (valueContext.NUMBER() != null) temp += valueContext.NUMBER() + ", ";
                    else if (valueContext.STRING() != null) temp += valueContext.STRING() + ", ";
                }
                temp = temp.substring(0,temp.length()-2);
                temp+="];\n";
            }
//            buffer.append("\t");
            buffer.append(temp);
        }
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPair(JSONParser.PairContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArr(JSONParser.ArrContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitValue(JSONParser.ValueContext ctx) { return visitChildren(ctx); }
}