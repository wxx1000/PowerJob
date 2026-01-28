//package tech.powerjob.server.persistence.config.dialect;
//
//import org.hibernate.boot.model.TypeContributions;
//import org.hibernate.dialect.PostgresPlusDialect;
//import org.hibernate.service.ServiceRegistry;
//
//import java.sql.Types;
//
//
///**
// * <a href="https://github.com/PowerJob/PowerJob/issues/750">PG数据库方言</a>
// * 使用方自行通过配置文件激活：spring.datasource.remote.hibernate.properties.hibernate.dialect=tech.powerjob.server.persistence.config.dialect.AdpPostgreSQLDialect
// *
// * @author litong0531
// * @since 2024/8/11
// */
//public class AdpPostgreSQLDialect extends PostgresPlusDialect {
//
//    public AdpPostgreSQLDialect() {
//        super();
//        registerColumnType(Types.BLOB, "bytea");
//        registerColumnType(Types.CLOB, "text");
//    }
//
//    @Override
//    protected void registerColumnTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
//        super.registerColumnTypes(typeContributions, serviceRegistry);
//    }
//
//    @Override
//    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
//        switch (sqlTypeDescriptor.getSqlType()) {
//            case Types.CLOB:
//                return LongVarcharTypeDescriptor.INSTANCE;
//            case Types.BLOB:
//                return LongVarbinaryTypeDescriptor.INSTANCE;
//            case Types.NCLOB:
//                return LongVarbinaryTypeDescriptor.INSTANCE;
//        }
//        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
//    }
//}
