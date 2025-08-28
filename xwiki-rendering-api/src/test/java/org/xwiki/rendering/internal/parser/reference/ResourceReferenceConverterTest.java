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
package org.xwiki.rendering.internal.parser.reference;

import org.junit.jupiter.api.Test;
import org.xwiki.rendering.listener.reference.ResourceReference;
import org.xwiki.rendering.listener.reference.ResourceType;
import org.xwiki.rendering.parser.ResourceReferenceParser;
import org.xwiki.test.junit5.mockito.ComponentTest;
import org.xwiki.test.junit5.mockito.InjectMockComponents;
import org.xwiki.test.junit5.mockito.MockComponent;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ResourceReferenceConverter}.
 *
 * @version $Id$
 */
@ComponentTest
class ResourceReferenceConverterTest
{
    @InjectMockComponents
    private ResourceReferenceConverter converter;

    @MockComponent
    private ResourceReferenceParser parser;

    @Test
    void convertToResourceReference()
    {
        ResourceReference reference = new ResourceReference("reference", ResourceType.DOCUMENT);

        when(this.parser.parse("reference")).thenReturn(reference);

        assertSame(reference, this.converter.convert(ResourceReference.class, "reference"));
    }

    @Test
    void convertToResourceReferenceWhenNull()
    {
        assertNull(this.converter.convert(ResourceReference.class, null));
    }
}
