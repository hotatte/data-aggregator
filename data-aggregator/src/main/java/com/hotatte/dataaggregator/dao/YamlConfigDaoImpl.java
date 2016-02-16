package com.hotatte.dataaggregator.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Inject;

import org.yaml.snakeyaml.Yaml;

import com.hotatte.dataaggregator.dto.Config;

public class YamlConfigDaoImpl implements ConfigDao {
	private final String configFileName;

	@Inject
	public YamlConfigDaoImpl() {
		this.configFileName = System.getProperty("config");
	}

	public YamlConfigDaoImpl(String configFileName) {
		this.configFileName = configFileName;
	}

	@Override
	public Config loadConfig() {
		Yaml yaml = new Yaml();

		try (BufferedReader reader = new BufferedReader(new FileReader(new File(configFileName)))) {
			return yaml.loadAs(reader, Config.class);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
