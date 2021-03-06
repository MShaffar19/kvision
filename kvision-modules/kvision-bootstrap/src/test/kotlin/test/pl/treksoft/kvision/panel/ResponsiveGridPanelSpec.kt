/*
 * Copyright (c) 2017-present Robert Jaros
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package test.pl.treksoft.kvision.panel

import pl.treksoft.kvision.html.Span
import pl.treksoft.kvision.panel.ResponsiveGridPanel
import pl.treksoft.kvision.panel.Root
import test.pl.treksoft.kvision.DomSpec
import kotlinx.browser.document
import kotlin.test.Test

class ResponsiveGridPanelSpec : DomSpec {

    @Test
    fun render() {
        run {
            val root = Root("test", containerType = pl.treksoft.kvision.panel.ContainerType.FIXED)
            val rgPanel = ResponsiveGridPanel()
            root.add(rgPanel)
            rgPanel.add(Span("abc"), 1, 1)
            rgPanel.add(Span("def"), 2, 2)
            rgPanel.add(Span("ghi"), 3, 3)
            val element = document.getElementById("test")
            assertEqualsHtml(
                "<div class=\"container-fluid\"><div class=\"row\"><div class=\"col-md-4\"><span>abc</span></div><div class=\"col-md-4\"></div><div class=\"col-md-4\"></div></div><div class=\"row\"><div class=\"col-md-4\"></div><div class=\"col-md-4\"><span>def</span></div><div class=\"col-md-4\"></div></div><div class=\"row\"><div class=\"col-md-4\"></div><div class=\"col-md-4\"></div><div class=\"col-md-4\"><span>ghi</span></div></div></div>",
                element?.innerHTML,
                "Should render correct responsive grid panel"
            )
        }
    }
}