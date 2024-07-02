package com.polenta.core.executor;

import com.polenta.core.executor.impl.AlterExecutor;
import com.polenta.core.executor.impl.CreateExecutor;
import com.polenta.core.executor.impl.DeleteExecutor;
import com.polenta.core.executor.impl.DropExecutor;
import com.polenta.core.executor.impl.InsertExecutor;
import com.polenta.core.executor.impl.SelectExecutor;
import com.polenta.core.executor.impl.ShutDownExecutor;
import com.polenta.core.executor.impl.UpdateExecutor;

public class StatementExecutorBuilder {

	private StatementExecutorBuilder() {
		
	}
	
	private  static StatementExecutorBuilder INSTANCE = new StatementExecutorBuilder();

	public static StatementExecutorBuilder getInstance() {
		return StatementExecutorBuilder.INSTANCE;
	}
	
	public StatementExecutor build(String statement) {
		StatementType commandType = StatementParser.extractCommandType(statement);
		StatementExecutor command;
		if (commandType == StatementType.ALTER) {
			command = new AlterExecutor();
		} else if (commandType == StatementType.CREATE) {
			command = new CreateExecutor();
		} else if (commandType == StatementType.DELETE) {
			command = new DeleteExecutor();
		} else if (commandType == StatementType.DROP) {
			command = new DropExecutor();
		} else if (commandType == StatementType.INSERT) {
			command = new InsertExecutor();
		} else if (commandType == StatementType.SELECT) {
			command = new SelectExecutor();
		} else if (commandType == StatementType.SHUTDOWN) {
			command = new ShutDownExecutor();
		} else if (commandType == StatementType.UPDATE) {
			command = new UpdateExecutor();
		} else {
			return null;
		}
		return command;
	}
	
	
}
