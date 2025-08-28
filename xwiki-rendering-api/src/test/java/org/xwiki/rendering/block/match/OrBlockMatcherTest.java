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
package org.xwiki.rendering.block.match;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.xwiki.rendering.block.FormatBlock;
import org.xwiki.rendering.block.GroupBlock;
import org.xwiki.rendering.block.WordBlock;
import org.xwiki.rendering.listener.Format;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link OrBlockMatcher}.
 *
 * @version $Id$
 * @since 4.3M2
 */
class OrBlockMatcherTest
{
    @Test
    void matchWhenUsingVarargConstructor()
    {
        OrBlockMatcher matcher = new OrBlockMatcher(
            new ClassBlockMatcher(GroupBlock.class),
            new ClassBlockMatcher(FormatBlock.class));

        assertTrue(matcher.match(new GroupBlock()));
        assertTrue(matcher.match(new FormatBlock(Collections.emptyList(), Format.BOLD)));
        assertFalse(matcher.match(new WordBlock("test")));
    }

    @Test
    void matchWhenUsingListConstructor()
    {
        OrBlockMatcher matcher = new OrBlockMatcher(Arrays.asList(
            new ClassBlockMatcher(GroupBlock.class),
            new ClassBlockMatcher(FormatBlock.class)));

        assertTrue(matcher.match(new GroupBlock()));
        assertTrue(matcher.match(new FormatBlock(Collections.emptyList(), Format.BOLD)));
        assertFalse(matcher.match(new WordBlock("test")));
    }
}
