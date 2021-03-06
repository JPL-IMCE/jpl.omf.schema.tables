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
 * An OML AnonymousConceptUnionAxiom specifies an anonymous logical union of DisjointUnionOfEntityAxioms in a concept taxonomy tree.
 * Although it is semantically anonymous, it is syntactically identified with name whose
 * only purpose is for generating the axiom's namespace UUID.
 */
trait AnonymousConceptUnionAxiom
  extends DisjointUnionOfConceptsAxiom
  with ConceptTreeDisjunction
{
  val name: gov.nasa.jpl.imce.oml.tables.taggedTypes.LocalName

  override val uuid: taggedTypes.AnonymousConceptUnionAxiomUUID
  override def bundleContainer
  ()(implicit extent: Extent): scala.Option[Bundle]
  def allNestedElements
  ()(implicit extent: Extent): scala.collection.immutable.Set[_ <: LogicalElement]
}

object AnonymousConceptUnionAxiom {

  def bundleContainer
  (a: AnonymousConceptUnionAxiom, ext: Extent)
  : scala.Option[Bundle]
  = a.bundleContainer()(ext)

  def allNestedElements
  (a: AnonymousConceptUnionAxiom, ext: Extent)
  : scala.collection.immutable.Set[_ <: LogicalElement]
  = a.allNestedElements()(ext)

}
