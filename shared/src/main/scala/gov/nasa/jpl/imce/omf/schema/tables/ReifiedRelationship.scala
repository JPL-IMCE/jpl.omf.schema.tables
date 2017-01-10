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

 
package gov.nasa.jpl.imce.omf.schema.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.JSExport
import scala._
import scala.Predef._

/**
  * @param graphUUID[1,1]
  * @param uuid[1,1]
  * @param isAbstract[1,1]
  * @param name[1,1]
  * @param unreifiedPropertyName[1,1]
  * @param unreifiedInversePropertyName[0,1]
  * @param iri[1,1]
  * @param isAsymmetric[1,1]
  * @param isEssential[1,1]
  * @param isFunctional[1,1]
  * @param isInverseEssential[1,1]
  * @param isInverseFunctional[1,1]
  * @param isIrreflexive[1,1]
  * @param isReflexive[1,1]
  * @param isSymmetric[1,1]
  * @param isTransitive[1,1]
  * @param sourceUUID[1,1]
  * @param targetUUID[1,1]
  */
case class ReifiedRelationship
(
  @(JSExport @field) graphUUID: UUID,
  @(JSExport @field) uuid: UUID,
  @(JSExport @field) isAbstract: scala.Boolean,
  @(JSExport @field) name: LocalName,
  @(JSExport @field) unreifiedPropertyName: LocalName,
  @(JSExport @field) unreifiedInversePropertyName: scala.Option[LocalName],
  @(JSExport @field) iri: IRI,
  @(JSExport @field) isAsymmetric: scala.Boolean,
  @(JSExport @field) isEssential: scala.Boolean,
  @(JSExport @field) isFunctional: scala.Boolean,
  @(JSExport @field) isInverseEssential: scala.Boolean,
  @(JSExport @field) isInverseFunctional: scala.Boolean,
  @(JSExport @field) isIrreflexive: scala.Boolean,
  @(JSExport @field) isReflexive: scala.Boolean,
  @(JSExport @field) isSymmetric: scala.Boolean,
  @(JSExport @field) isTransitive: scala.Boolean,
  @(JSExport @field) sourceUUID: UUID,
  @(JSExport @field) targetUUID: UUID
) {
  @JSExport
  def this(
    graphUUID: UUID,
    uuid: UUID,
    isAbstract: scala.Boolean,
    name: LocalName,
    unreifiedPropertyName: LocalName,
    iri: IRI,
    isAsymmetric: scala.Boolean,
    isEssential: scala.Boolean,
    isFunctional: scala.Boolean,
    isInverseEssential: scala.Boolean,
    isInverseFunctional: scala.Boolean,
    isIrreflexive: scala.Boolean,
    isReflexive: scala.Boolean,
    isSymmetric: scala.Boolean,
    isTransitive: scala.Boolean,
    sourceUUID: UUID,
    targetUUID: UUID)
  = this(
      graphUUID,
      uuid,
      isAbstract,
      name,
      unreifiedPropertyName,
      None /* unreifiedInversePropertyName */,
      iri,
      isAsymmetric,
      isEssential,
      isFunctional,
      isInverseEssential,
      isInverseFunctional,
      isIrreflexive,
      isReflexive,
      isSymmetric,
      isTransitive,
      sourceUUID,
      targetUUID)

  def withUnreifiedInversePropertyName(l: LocalName)	 
  : ReifiedRelationship
  = copy(unreifiedInversePropertyName=Some(l))
  
  override val hashCode
  : scala.Int 
  = (graphUUID, uuid, isAbstract, name, unreifiedPropertyName, unreifiedInversePropertyName, iri, isAsymmetric, isEssential, isFunctional, isInverseEssential, isInverseFunctional, isIrreflexive, isReflexive, isSymmetric, isTransitive, sourceUUID, targetUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: ReifiedRelationship =>
  	  (this.graphUUID == that.graphUUID) &&
  	  (this.uuid == that.uuid) &&
  	  (this.isAbstract == that.isAbstract) &&
  	  (this.name == that.name) &&
  	  (this.unreifiedPropertyName == that.unreifiedPropertyName) &&
  	  (this.unreifiedInversePropertyName == that.unreifiedInversePropertyName) &&
  	  (this.iri == that.iri) &&
  	  (this.isAsymmetric == that.isAsymmetric) &&
  	  (this.isEssential == that.isEssential) &&
  	  (this.isFunctional == that.isFunctional) &&
  	  (this.isInverseEssential == that.isInverseEssential) &&
  	  (this.isInverseFunctional == that.isInverseFunctional) &&
  	  (this.isIrreflexive == that.isIrreflexive) &&
  	  (this.isReflexive == that.isReflexive) &&
  	  (this.isSymmetric == that.isSymmetric) &&
  	  (this.isTransitive == that.isTransitive) &&
  	  (this.sourceUUID == that.sourceUUID) &&
  	  (this.targetUUID == that.targetUUID)
    case _ =>
      false
  }
  
}

@JSExport
object ReifiedRelationshipHelper {

  val TABLE_JSON_FILENAME 
  : scala.Predef.String 
  = "ReifiedRelationships.json"
  
  implicit val w
  : upickle.default.Writer[ReifiedRelationship]
  = upickle.default.macroW[ReifiedRelationship]

  @JSExport
  def toJSON(c: ReifiedRelationship)
  : String
  = upickle.default.write(expr=c, indent=0)

  implicit val r
  : upickle.default.Reader[ReifiedRelationship]
  = upickle.default.macroR[ReifiedRelationship]

  @JSExport
  def fromJSON(c: String)
  : ReifiedRelationship
  = upickle.default.read[ReifiedRelationship](c)

}	
