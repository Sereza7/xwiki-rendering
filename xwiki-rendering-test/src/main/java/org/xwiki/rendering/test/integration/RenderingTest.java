/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.test.integration;

import java.util.List;
import java.util.Map;

import org.junit.ComparisonFailure;
import org.junit.Test;
import org.xwiki.component.manager.ComponentManager;

/**
 * A generic JUnit 4 Test to parse some passed content and verify it matches some passed expectation.
 * The format of the input/expectation is specified in {@link TestDataParser}.
 *
 * @version $Id$
 * @since 3.0RC1
 */
public class RenderingTest extends AbstractRenderingTest
{
    public RenderingTest(String input, String expected, String parserId, String targetSyntaxId,
        boolean streaming, List<String> transformations, Map<String, ?> configuration,
        ComponentManager componentManager)
    {
        super(input, expected, parserId, targetSyntaxId, streaming, transformations, configuration, componentManager);
    }

    @Test
    public void execute() throws Exception
    {
        super.execute();
    }

    @Override
    protected void throwAssertionException(String message, String expected, String result)
    {
        throw new ComparisonFailure(message, expected, result);
    }
}
