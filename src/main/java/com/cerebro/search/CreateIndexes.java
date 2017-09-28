package com.cerebro.search;

import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import com.cerebro.util.Constants;

public class CreateIndexes {

	public static void main(String[] args) {
		try {
			Indexer indexer = new Indexer(Constants.indexDirectory);
			LocalDateTime startTime = LocalDateTime.now(Clock.systemDefaultZone());
			int numIndexed = indexer.createIndex(Constants.dataDirectory, new CerebroFilter());
			LocalDateTime endTime = LocalDateTime.now(Clock.systemDefaultZone());

			indexer.close();
			System.out.println(numIndexed + " files indexed. Time taken: "
					+ Duration.between(startTime, endTime).getSeconds());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
