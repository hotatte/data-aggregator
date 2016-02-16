package com.hotatte.dataaggregator;

import javax.inject.Inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.hotatte.dataaggregator.dao.CSVRecordDaoImpl;
import com.hotatte.dataaggregator.dao.ConfigDao;
import com.hotatte.dataaggregator.dao.RecordDao;
import com.hotatte.dataaggregator.dao.YamlConfigDaoImpl;
import com.hotatte.dataaggregator.dto.Config;

public class DIModule extends AbstractModule{

	private final String configFileName;

	public DIModule(String configFileName) {
		super();
		this.configFileName = configFileName;
	}

	@Override
	protected void configure() {
		bind(RecordDao.class).to(CSVRecordDaoImpl.class);
		bind(ConfigDao.class).toInstance(new YamlConfigDaoImpl(configFileName));
		bind(Config.class).toProvider(ConfigProvider.class);
	}
	
	private static class ConfigProvider implements Provider<Config> {
		private final Config config;
		
		@Inject
		public ConfigProvider(ConfigDao configDao) {
			this.config = configDao.loadConfig();
		}

		@Override
		public Config get() {
			return this.config;
		}
		
	}

}
