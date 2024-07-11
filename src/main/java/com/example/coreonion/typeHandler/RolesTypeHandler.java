package com.example.coreonion.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RolesTypeHandler extends BaseTypeHandler<Set<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Set<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, String.join(",", parameter));
    }

    @Override
    public Set<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String rolesString = rs.getString(columnName);
        return rolesString == null ? null : new HashSet<>(Arrays.asList(rolesString.split(",")));
    }

    @Override
    public Set<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String rolesString = rs.getString(columnIndex);
        return rolesString == null ? null : new HashSet<>(Arrays.asList(rolesString.split(",")));
    }

    @Override
    public Set<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String rolesString = cs.getString(columnIndex);
        return rolesString == null ? null : new HashSet<>(Arrays.asList(rolesString.split(",")));
    }
}
