package in.cdac.builderdesign;

@WithBuilder
public class Query {

    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    static  class QueryBuilder{
    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;
    private QueryBuilder()
    {

    }
     public QueryBuilder setSelect(String select) {
        this.select=select;
        return this;
    }

    public QueryBuilder setFrom(String from) {
       this.from=from;
       return this;
    }

    public QueryBuilder setWhere(String where) {
        this.where= where;
        return this;
    }

    public QueryBuilder setJoin(String join) {
        this.join=join;
        return this;
    }

    public QueryBuilder setOrderBy(String orderBy) {
        this.orderBy=orderBy;
        return this;
    }

    public QueryBuilder setGroupBy(String groupBy) {
        this.groupBy=groupBy;
        return this;
    }
     public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getJoin() {
        return join;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }
    public Query build()
    {
            return new Query(this);
    }
    
        
    }

   private Query(QueryBuilder builder)
    {
             this.select=builder.select;
             this.from=builder.from;
             this.join=builder.join;
             this.orderBy=builder.orderBy;
             this.groupBy=builder.groupBy;
             this.where=builder.where;
    }

    public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getJoin() {
        return join;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }
    
    public static QueryBuilder getBuilder()
    {
    	return new QueryBuilder();
    }
}

