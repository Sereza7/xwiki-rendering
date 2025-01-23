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
package org.xwiki.rendering.internal.renderer.xhtml.image;

import javax.inject.Inject;
import javax.inject.Named;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.InstantiationStrategy;
import org.xwiki.component.descriptor.ComponentInstantiationStrategy;
import org.xwiki.rendering.internal.renderer.xhtml.XHTMLRendererFactory;
import org.xwiki.rendering.listener.reference.ResourceReference;
import org.xwiki.rendering.renderer.PrintRenderer;
import org.xwiki.rendering.renderer.printer.DefaultWikiPrinter;
import org.xwiki.rendering.renderer.printer.WikiPrinter;
import org.xwiki.rendering.renderer.printer.XHTMLWikiPrinter;
import org.xwiki.rendering.util.IconProvider;

import java.util.Map;

/**
 * Handle XHTML rendering for icon images.
 *
 * @version $Id$
 * @since 5.4RC1
 */
@Component
@Named("icon")
@InstantiationStrategy(ComponentInstantiationStrategy.PER_LOOKUP)
public class IconXHTMLImageTypeRenderer extends AttachmentXHTMLImageTypeRenderer
{
    @Inject
    private IconProvider iconProvider;
    @Inject
    private XHTMLRendererFactory xhtmlRendererFactory;
    /** 
     * Icons are technically images but can sometimes be rendered as other elements depending on the iconSet.
     * @since 17.1.0RC1
     */
    @Override
    public void onImage(ResourceReference reference, boolean freestanding, String id, Map<String, String> parameters)
    {
        XHTMLWikiPrinter printer = getXHTMLWikiPrinter();
        PrintRenderer renderer = xhtmlRendererFactory.createRenderer(printer);
        // We compute the content of this icon and then make sure we traverse the content.
        iconProvider.get(reference.getReference()).traverse(renderer);
    }
}
