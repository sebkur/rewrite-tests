package de.topobyte.rewrite;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.netflix.rewrite.ast.Tr.CompilationUnit;
import com.netflix.rewrite.parse.OracleJdkParser;
import com.netflix.rewrite.parse.Parser;
import com.netflix.rewrite.refactor.Refactor;

import de.topobyte.system.utils.SystemPaths;

public class Test
{

	public static void main(String[] args)
	{
		Parser parser = new OracleJdkParser();

		List<Path> files = new ArrayList<>();

		files.add(SystemPaths.HOME
				.resolve("github/OpenMetroMaps/OpenMetroMaps/java/maps-gwt/build/unpackedJars/com/slimjars/dist/gnu/trove/set/hash/TIntHashSet.java"));

		List<CompilationUnit> cus = parser.parse(files);
		for (CompilationUnit cu : cus) {
			System.out.println(cu.getSourcePath());
			System.out.println(cu.getClasses().size());
			Refactor refactor = cu.refactor();
			refactor.fix();
		}
	}

}