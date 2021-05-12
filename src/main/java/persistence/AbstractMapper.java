package persistence;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;


public abstract class AbstractMapper<T> {

    @FunctionalInterface
    protected interface SQL_TriConsumer<T,U>{
        void accept(T t, U u, ResultSet rs) throws SQLException;
    }

    private final Map<String, SQL_TriConsumer<T,String>> map;

    protected AbstractMapper(Map<String, SQL_TriConsumer<T, String>> map) {
        this.map = map;
    }

    protected abstract T instantiate();

    public T toBean(ResultSet rs) throws SQLException{
        ResultSetMetaData rsmd = rs.getMetaData();
        T bean = instantiate();

        for(int i=1; i<=rsmd.getColumnCount(); i++){
            String column = rsmd.getColumnLabel(i);

            SQL_TriConsumer<T, String> setter = map.get(column);
            if(setter != null){
                Object o = rs.getObject(i);
                setter.accept(bean, column, rs);
            }
        }
        return bean;
    }


}