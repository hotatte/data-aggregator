package com.hotatte.dataaggregator.dao;

import java.io.IOException;
import java.util.stream.Stream;

import com.hotatte.dataaggregator.dto.Record;

public interface RecordDao {
	Stream<Record> stream() throws IOException;
}
