/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package gov.nasa.jpl.imce.oml.resolver.api

/*
 * An OML TerminologyGraph is an OML TerminologyBox with no statements our axioms involving OML Bundle(s).
 */
trait TerminologyGraph
  extends TerminologyBox
{
  override val uuid: taggedTypes.TerminologyGraphUUID

  override def moduleEdges
  ()(implicit extent: Extent): scala.collection.immutable.Set[_ <: ModuleEdge]
  def moduleElements
  ()(implicit extent: Extent): scala.collection.immutable.Set[_ <: ModuleElement]
}

object TerminologyGraph {

  def moduleEdges
  (t: TerminologyGraph, ext: Extent)
  : scala.collection.immutable.Set[_ <: ModuleEdge]
  = t.moduleEdges()(ext)

  def moduleElements
  (t: TerminologyGraph, ext: Extent)
  : scala.collection.immutable.Set[_ <: ModuleElement]
  = t.moduleElements()(ext)

}
